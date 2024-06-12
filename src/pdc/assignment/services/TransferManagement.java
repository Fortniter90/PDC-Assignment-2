/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment.services;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pdc.assignment.model.Transfer;
import pdc.assignment.model.Locations;
import pdc.assignment.model.Items;
import pdc.assignment.pkg2.BaseLog;
import static pdc.assignment.pkg2.BaseLog.logger;
import pdc.assignment.pkg2.HibernateUtil;

/**
 *
 * @author Ethan
 */
public class TransferManagement extends BaseLog implements TransferInterface {

    @Override
    public boolean transferItem(Transfer transfer) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            Items item = transfer.getItem();
            Items loadedItem = (Items) session.get(Items.class, item.getId());
            if (loadedItem != null) {
                loadedItem.setQuantity(transfer.getQuantity() - item.getQuantity());
                session.update(loadedItem);

                ItemInterface it = new ItemManagement();
                Items it1 = new Items(item.getName(), item.getPrice(), item.getQuantity(), transfer.getDestLocation());
                boolean work = it.transferAddItem(session, it1);
                if (false == work) {
                    Items loadedItem2 = it.itemTransferLoad(session, item.getName(), transfer.getDestLocation());
                    loadedItem2.setQuantity(transfer.getQuantity());
                    session.update(loadedItem2);
                }
                status = true;
                session.save(transfer);
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in LocationMangement - loadLocation!");
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Transfer> browseTransfers() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        List<Transfer> transfers = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Transfer");
            transfers = query.list();
            if (transfers != null) {
                for (Transfer transfer : transfers) {
                    System.out.println("Name: " + transfer.getItem().getName() + transfer.getSourceLocation().getName() + transfer.getDestLocation().getName());
                }
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info("ERROR Occurs in LocationMangement - browseLocations!");
            e.printStackTrace();
        }
        return transfers;
    }

}
