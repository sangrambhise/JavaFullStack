package com.wipro.process;

import org.springframework.stereotype.Component;
import com.wipro.exception.NoSeatAvailableException;

@Component
public class AirTravelProcess {

    public void checkIn(Boolean seatAvailable) throws NoSeatAvailableException {
        if (seatAvailable) {
            System.out.println("Check-in successful.");
        } else {
            throw new NoSeatAvailableException(" No seats available!");
        }
    }

    public void collectBoardingPass() {
        System.out.println(" Boarding pass collected.");
    }

    public void doSecurityCheck() {
        System.out.println(" Security check done.");
    }

    public void doBoarding() {
        System.out.println(" Boarding complete.");
    }
}
