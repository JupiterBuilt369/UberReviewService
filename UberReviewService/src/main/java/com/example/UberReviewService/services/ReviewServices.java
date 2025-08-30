package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class ReviewServices implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> RUN METHOD CALLED <<<");

        System.out.println("*******");

//        Review r = Review.builder()
//                .content("new ride at  " +   LocalTime.now())
//                .rating(9.41)
//        .build();
//
//        Booking b = Booking.builder()
//                .review(r)
//                .endTIme(new Date())
//        .build();
//
//        bookingRepository.save(b);


//        Optional<Booking> b = bookingRepository.findById(3L);
//        if (b.isPresent()){
//            bookingRepository.delete(b.get());
//        }
/*
        Optional<Driver> driver = driverRepository.rawFindByIdAndLicenseNumber(4L, "KA-01-EF-5566");

        if (driver.isPresent()) {
            System.out.println("Driver found: " + driver.get().getName());
            List<Booking> bookings = driver.get().getBookings();
            for (Booking b : bookings){
                System.out.println(b.getPassenger().getName());
            }
        } else {
            System.out.println("No driver found with given id & license number");
        }
*/
/*

        Optional<Driver> driver2 = driverRepository.findByIdAndLicenseNumber(6L, "KL-07-IJ-9900");

        if (driver2.isPresent()) {
            System.out.println("Driver found: " + driver2.get().getName());
            List<Booking> bookings = driver2.get().getBookings();
            for (Booking b : bookings){
                System.out.println(b.getPassenger().getName());
            }
        } else {
            System.out.println("No driver found with given id & license number");
        }

        */

/*
        List<Booking> bookings = bookingRepository.findByBookingStatus(BookingStatus.CAB_ARRIVED);
        if(bookings == null || bookings.isEmpty()) {
            System.out.println("no booking of status : CAB_ARRIVED" );
        }
        else{
            bookings.forEach(b -> System.out.println("Booking ID: " + b.getId() +
                    ", Passenger ID: " + b.getPassenger().getId() +
                    ", Passenger Name: " + b.getPassenger().getName() +
                    ", Driver ID: " + b.getDriver().getId() +
                    ", Driver Name: " + b.getDriver().getName() +
                    ", Status: " + b.getBookingStatus()
                    )
            );
        }
        */

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L,6L,5L,9L,8L,11L,15L));

        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);
        for (Driver driver: drivers){
            List<Booking> bookings = driver.getBookings();
            for (Booking booking : bookings) {
                System.out.println(driver.getId() +"-->"+booking.getId());
            }
        }

    }
}
