package eu.epfc.java1888.fly;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity
public class Fly {
    @Id @GeneratedValue
    private Long id;
    private String number;
    private String departureAirport;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime departureTime;
    private String arrivalAirport;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime arrivalTime;
    private String company;
    private double price;


}
