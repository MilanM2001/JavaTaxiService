package GUI.DriverOptions.DriverAuction;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;

public class OffersTableModel extends AbstractTableModel {

    private LinkedList<Offer> offers;

    private final String[] columnNames = new String[] {
            "datum kreiranja", "vozac", "potrebno minuta"
    };

    private final Class[] columnClass = new Class[] {
            LocalDateTime.class, String.class, Integer.class
    };

    public OffersTableModel(LinkedList<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return columnClass[column];
    }

    @Override
    public int getRowCount() {
        return offers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Offer offer = offers.get(row);

        Driver driver = offer.getDriver();

        switch(column) {
            case 0:
                return offer.getDateOfCreation();
            case 1:
                return offer.getDriver() != null ? driver.getFirstName() + " " + driver.getLastName() : "-";
            case 2:
                return offer.getMinutes();
        }

        return "-";
    }

}
