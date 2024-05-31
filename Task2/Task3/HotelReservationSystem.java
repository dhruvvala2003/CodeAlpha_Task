package Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem extends JFrame {
    private JPanel mainPanel;
    private JButton searchButton;
    private JButton bookButton;
    private JButton viewButton;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JComboBox<String> roomTypeComboBox;
    private JTextArea outputArea;

    private List<Room> rooms;
    private List<Reservation> reservations;
    private int reservationIdCounter = 1;

    public HotelReservationSystem() {
        initializeComponents();
        setContentPane(mainPanel);
        setTitle("Hotel Reservation System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        populateRooms();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRooms();
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookRoom();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewReservations();
            }
        });
    }

    private void initializeComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Check-In Date:"));
        checkInField = new JTextField();
        inputPanel.add(checkInField);

        inputPanel.add(new JLabel("Check-Out Date:"));
        checkOutField = new JTextField();
        inputPanel.add(checkOutField);

        inputPanel.add(new JLabel("Room Type:"));
        roomTypeComboBox = new JComboBox<>(new String[] { "Single", "Double", "Suite" });
        inputPanel.add(roomTypeComboBox);

        searchButton = new JButton("Search Rooms");
        inputPanel.add(searchButton);

        bookButton = new JButton("Book Room");
        inputPanel.add(bookButton);

        viewButton = new JButton("View Reservations");
        inputPanel.add(viewButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    private void populateRooms() {
        rooms.add(new Room(1, "Single", 50.0, true));
        rooms.add(new Room(2, "Double", 80.0, true));
        rooms.add(new Room(3, "Suite", 120.0, true));
    }

    private void searchRooms() {
        String roomType = (String) roomTypeComboBox.getSelectedItem();
        outputArea.setText("");

        boolean found = false;
        for (Room room : rooms) {
            if (room.type.equals(roomType) && room.available) {
                outputArea.append("Room ID: " + room.id + ", Price: $" + room.price + "\n");
                found = true;
            }
        }
        if (!found) {
            outputArea.append("No available rooms of the selected type.\n");
        }
    }

    private void bookRoom() {
        String name = nameField.getText();
        String email = emailField.getText();
        String checkIn = checkInField.getText();
        String checkOut = checkOutField.getText();
        String roomType = (String) roomTypeComboBox.getSelectedItem();

        for (Room room : rooms) {
            if (room.type.equals(roomType) && room.available) {
                room.available = false;
                double price = room.price;

                reservations.add(new Reservation(reservationIdCounter++, room.id, name, email, checkIn, checkOut, price));
                outputArea.setText("Room booked successfully!\nReservation ID: " + (reservationIdCounter - 1) + ", Room ID: " + room.id + "\n");
                return;
            }
        }
        outputArea.setText("No available rooms of the selected type.\n");
    }

    private void viewReservations() {
        outputArea.setText("");
        for (Reservation reservation : reservations) {
            outputArea.append("Reservation ID: " + reservation.id + ", Room ID: " + reservation.roomId +
                    ", Guest: " + reservation.guestName + ", Email: " + reservation.guestEmail +
                    ", Check-in: " + reservation.checkInDate + ", Check-out: " + reservation.checkOutDate +
                    ", Amount Paid: $" + reservation.amountPaid + "\n");
        }
    }

    public static void main(String[] args) {
        new HotelReservationSystem();
    }
}
