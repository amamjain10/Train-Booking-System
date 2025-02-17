import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainTicketBookingSystem extends JFrame implements ActionListener {
    JLabel lblTitle, lblDeparture, lblArrival, lblDate, lblPassengers, lblClass, lblTotal;
    JComboBox<String> cbDeparture, cbArrival, cbClass;
    JTextField tfDate, tfPassengers;
    JButton btnBookTicket;
    JTextArea taConfirmation;
    double ticketPrice;
    private JLabel lblName;
    private JTextField txtName;

    public TrainTicketBookingSystem() {
        setTitle("Train Ticket Booking System");
        setSize(401, 424);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitle = new JLabel("Train Ticket Booking System");
        lblTitle.setFont(new Font("Arial Black", Font.BOLD, 14));
        lblDeparture = new JLabel("Departure Station:");
        lblArrival = new JLabel("Arrival Station:");
        lblDate = new JLabel("Date (DD/MM/YYYY):");
        lblPassengers = new JLabel("Number of Passengers:");
        lblClass = new JLabel("Class:");
        lblTotal = new JLabel("Total Price: ₹0.00");

        String[] stations = {"Select","Katra","Mussorie","Faridabad","New Delhi","Gaziabad","Beawar","Jaipur","Mirzapur","Patna","Kolkata","Ranchi","Indore","Ahmedabad","Mumbai","Vasco-da-Gama(Goa)","KSR Bengaluru","Hyderabad","Amravati","Puducherry","Chennai","Kochi"};
        cbDeparture = new JComboBox<>(stations);
        cbArrival = new JComboBox<>(stations);

        String[] classes = {"AC-I","AC-II","AC-III","SL","GEN"};
        cbClass = new JComboBox<>(classes);

        tfDate = new JTextField(10);
        tfPassengers = new JTextField(10);
        tfPassengers.setText("0");

        btnBookTicket = new JButton("Book Ticket");
        btnBookTicket.setBackground(new Color(135, 206, 250));
        btnBookTicket.setForeground(new Color(0, 0, 0));
        btnBookTicket.addActionListener(this);
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, lblClass, 184, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblPassengers, -221, SpringLayout.SOUTH, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, cbClass, 181, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, btnBookTicket, 180, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, tfPassengers, -3, SpringLayout.NORTH, lblPassengers);
        springLayout.putConstraint(SpringLayout.WEST, tfPassengers, 6, SpringLayout.WEST, tfDate);
        springLayout.putConstraint(SpringLayout.EAST, lblPassengers, 0, SpringLayout.EAST, lblDate);
        springLayout.putConstraint(SpringLayout.WEST, lblTotal, 6, SpringLayout.EAST, btnBookTicket);
        springLayout.putConstraint(SpringLayout.SOUTH, lblTotal, 0, SpringLayout.SOUTH, cbClass);
        springLayout.putConstraint(SpringLayout.EAST, cbClass, 0, SpringLayout.EAST, lblDeparture);
        springLayout.putConstraint(SpringLayout.EAST, lblDeparture, -285, SpringLayout.EAST, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblClass, 0, SpringLayout.WEST, lblDeparture);
        springLayout.putConstraint(SpringLayout.EAST, btnBookTicket, 0, SpringLayout.EAST, tfDate);
        springLayout.putConstraint(SpringLayout.NORTH, tfDate, 6, SpringLayout.SOUTH, cbArrival);
        springLayout.putConstraint(SpringLayout.WEST, tfDate, 8, SpringLayout.WEST, cbArrival);
        springLayout.putConstraint(SpringLayout.NORTH, lblDate, 9, SpringLayout.SOUTH, cbArrival);
        springLayout.putConstraint(SpringLayout.WEST, lblDate, 0, SpringLayout.WEST, lblDeparture);
        springLayout.putConstraint(SpringLayout.NORTH, lblArrival, 3, SpringLayout.NORTH, cbArrival);
        springLayout.putConstraint(SpringLayout.WEST, lblArrival, 0, SpringLayout.WEST, lblDeparture);
        springLayout.putConstraint(SpringLayout.NORTH, cbArrival, 6, SpringLayout.SOUTH, cbDeparture);
        springLayout.putConstraint(SpringLayout.WEST, cbArrival, 0, SpringLayout.WEST, cbDeparture);
        springLayout.putConstraint(SpringLayout.NORTH, cbDeparture, -3, SpringLayout.NORTH, lblDeparture);
        springLayout.putConstraint(SpringLayout.WEST, cbDeparture, 16, SpringLayout.EAST, lblDeparture);
        springLayout.putConstraint(SpringLayout.NORTH, lblDeparture, 16, SpringLayout.SOUTH, lblTitle);
        springLayout.putConstraint(SpringLayout.WEST, lblTitle, 73, SpringLayout.WEST, getContentPane());
        getContentPane().setLayout(springLayout);

        getContentPane().add(lblTitle);
        getContentPane().add(lblDeparture);
        getContentPane().add(cbDeparture);
        getContentPane().add(lblArrival);
        getContentPane().add(cbArrival);
        getContentPane().add(lblDate);
        getContentPane().add(tfDate);
        getContentPane().add(lblPassengers);
        getContentPane().add(tfPassengers);
        getContentPane().add(lblClass);
        getContentPane().add(cbClass);
        getContentPane().add(btnBookTicket);
        getContentPane().add(lblTotal);
        JScrollPane scrollPane = new JScrollPane();
        springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 0, SpringLayout.NORTH, scrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 1146, SpringLayout.WEST, getContentPane());
        getContentPane().add(scrollPane);
        
                taConfirmation = new JTextArea(5, 30);
                springLayout.putConstraint(SpringLayout.NORTH, taConfirmation, 29, SpringLayout.SOUTH, btnBookTicket);
                springLayout.putConstraint(SpringLayout.EAST, taConfirmation, 0, SpringLayout.EAST, lblTitle);
                getContentPane().add(taConfirmation);
                taConfirmation.setEditable(false);
                
                lblName = new JLabel("Booking Name:");
                springLayout.putConstraint(SpringLayout.NORTH, lblName, 6, SpringLayout.SOUTH, lblDate);
                springLayout.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblDeparture);
                springLayout.putConstraint(SpringLayout.SOUTH, lblName, 27, SpringLayout.SOUTH, lblDate);
                springLayout.putConstraint(SpringLayout.EAST, lblName, 0, SpringLayout.EAST, lblDate);
                getContentPane().add(lblName);
                
                txtName = new JTextField(10);
                springLayout.putConstraint(SpringLayout.WEST, txtName, 2, SpringLayout.EAST, lblName);
                springLayout.putConstraint(SpringLayout.EAST, txtName, -163, SpringLayout.EAST, getContentPane());
                springLayout.putConstraint(SpringLayout.EAST, tfPassengers, -10, SpringLayout.EAST, txtName);
                springLayout.putConstraint(SpringLayout.NORTH, txtName, 9, SpringLayout.SOUTH, tfDate);
                springLayout.putConstraint(SpringLayout.SOUTH, txtName, 29, SpringLayout.SOUTH, tfDate);
                getContentPane().add(txtName);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBookTicket) {
            String departure = (String) cbDeparture.getSelectedItem();
            String arrival = (String) cbArrival.getSelectedItem();
            String date = tfDate.getText();
            int passengers = Integer.parseInt(tfPassengers.getText());
            String trainClass = (String) cbClass.getSelectedItem();

            if (!isValidDate(date)) {
                JOptionPane.showMessageDialog(this,"Enter a valid date!","Error",
                                JOptionPane.ERROR_MESSAGE);
                return; // Exit the method
            }
            
            if (departure.equals(arrival)) {
                JOptionPane.showMessageDialog(this, 
                    "Departure and Arrival stations cannot be the same!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit the method to prevent further execution
            }
            
            if (trainClass.equals("AC-I")) {
                ticketPrice = 1000.0;
            }
            else if(trainClass.equals("AC-II")) {
                ticketPrice = 800.0;
            }
            else if(trainClass.equals("AC-III")) {
            	ticketPrice = 500.0;
            }
            else if(trainClass.equals("SL")) {
            	ticketPrice = 300.0;
            }
            else {
            	ticketPrice = 150.0;
            }

            double totalPrice = ticketPrice * passengers;

            lblTotal.setText("Total Price: ₹" + totalPrice);

            if(totalPrice <= 0) {
            	JOptionPane.showMessageDialog(this, 
                        "Enter No. of Passengers", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
            }
            
            String confirmationMessage = "Ticket Details:\n" +
                    "Departure: " + departure + "\n" +
                    "Arrival: " + arrival + "\n" +
                    "Date: " + date + "\n" +
                    "Class: " + trainClass + "\n" +
                    "Passengers: " + passengers + "\n" +
                    "Total Price: ₹" + totalPrice;
            taConfirmation.setText(confirmationMessage);
        }
    }

    private boolean isValidDate(String date){
        try {
            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date, formatter); // Try to parse the date
            return true; // Parsing successful, date is valid
        }
        catch (DateTimeParseException e) {
        	return false;
        }
    }
    
    public static void main(String[] args) {
        new TrainTicketBookingSystem();
    }
}
