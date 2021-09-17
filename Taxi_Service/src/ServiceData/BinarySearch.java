package ServiceData;
import AllUsers.Customer;
import AllUsers.Dispatcher;
import AllUsers.Driver;
import AllUsers.Users;
import Cars.Car;
import Rides.Offer;
import Rides.Ride;

import java.util.ArrayList;

public class BinarySearch {

    private static int binarySearchDriverById(int id, ArrayList<Driver> drivers) {
        int firstElement = 0;
        int lastElement = drivers.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (drivers.get(middleElement).getId() == id)
                return middleElement;

            if (drivers.get(middleElement).getId() < id)
                firstElement = middleElement + 1;

            if (drivers.get(middleElement).getId() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }

    private static int binarySearchCustomerById(int id, ArrayList<Customer> customers) {
        int firstElement = 0;
        int lastElement = customers.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (customers.get(middleElement).getId() == id)
                return middleElement;

            if (customers.get(middleElement).getId() < id)
                firstElement = middleElement + 1;

            if (customers.get(middleElement).getId() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }

    private static int binarySearchDispatcherById(int id, ArrayList<Dispatcher> dispatchers) {
        int firstElement = 0;
        int lastElement = dispatchers.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (dispatchers.get(middleElement).getId() == id)
                return middleElement;

            if (dispatchers.get(middleElement).getId() < id)
                firstElement = middleElement + 1;

            if (dispatchers.get(middleElement).getId() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }

    private static int binarySearchCarsById(int id, ArrayList<Car> cars) {
        int firstElement = 0;
        int lastElement = cars.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (cars.get(middleElement).getCarID() == id)
                return middleElement;

            if (cars.get(middleElement).getCarID() < id)
                firstElement = middleElement + 1;

            if (cars.get(middleElement).getCarID() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }

    private static int binarySearchRidesById(int id, ArrayList<Ride> rides) {
        int firstElement = 0;
        int lastElement = rides.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (rides.get(middleElement).getRideID() == id)
                return middleElement;

            if (rides.get(middleElement).getRideID() < id)
                firstElement = middleElement + 1;

            if (rides.get(middleElement).getRideID() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }

    private static int binarySearchOffersById(int id, ArrayList<Offer> offers) {
        int firstElement = 0;
        int lastElement = offers.size() - 1;

        while (firstElement <= lastElement) {
            int middleElement = firstElement + (lastElement - firstElement) / 2;

            if (offers.get(middleElement).getRideID() == id)
                return middleElement;

            if (offers.get(middleElement).getRideID() < id)
                firstElement = middleElement + 1;

            if (offers.get(middleElement).getRideID() > id)
                lastElement = middleElement - 1;
        }

        return -1;
    }
}
