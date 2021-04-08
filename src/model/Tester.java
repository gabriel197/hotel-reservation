package model;

import ui.MainMenu;

import java.text.ParseException;

public class Tester {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(sdf.parse("01-12-2020"));
//        Customer customer = new Customer("Gabriel", "Maracine", "gabriel03@gmai.com");
//        Room room = new Room("3", 55d, RoomType.SINGLE);
//        Date dateIn = Calendar.getInstance().getTime();
//
//        Calendar dateOut = Calendar.getInstance();
//        dateOut.set(2021,Calendar.JANUARY,1);
//        Date thisDAte = dateOut.getTime();
//        Reservation reservation = new Reservation(customer, room, dateIn, thisDAte);
//
//        System.out.println(reservation);
//        Object object = new FreeRoom("2", RoomType.DOUBLE);
//        FreeRoom freeRoom = new FreeRoom("2", RoomType.DOUBLE);
//        System.out.println(object.equals(freeRoom));
//        int x = object.hashCode();
//        int y = freeRoom.hashCode();
//        Object customer = new Customer("a", "b", "a@a.com");
//        x = customer.hashCode();
//        Customer customer1 = new Customer("a", "b", "a@a.com");
//        y = customer1.hashCode();
//
//        System.out.println(x + " " + y);

//        try(Scanner scanner = new Scanner(System.in)) {
//            String first, last, email = "0", emailInput;
//            System.out.println("create a object:");
//            System.out.println("First name:");
//             first = scanner.nextLine();
//            System.out.println("Last name: ");
//            last = scanner.nextLine();
//            System.out.println("email:");
//            while (email.equals("0")) {
//                    emailInput = scanner.nextLine();
//                    if(Customer.validEmail(emailInput)) email = emailInput;
//
//
//            }
//            Customer customer = new Customer(first, last, email);
//            System.out.println(customer);

//        Date date = new Date();
//        Calendar c = Calendar.getInstance();
//        c.set();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        String strDAte = format.format(date);
//        System.out.println(strDAte);

//        int x = testsome();
//        System.out.println(x);
//
//
//
//
//        }
//
//        static int testsome() {
//        try {
//            int[] x = {1};
//            x[5] = 1;
//        } catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println(exception.getLocalizedMessage());
//        } return 5;
        MainMenu.start();
//        IRoom rom = new Room("a", 2d, RoomType.SINGLE);
//        System.out.println(rom.getClass());
//        System.out.println(FreeRoom.class);

        }




}
