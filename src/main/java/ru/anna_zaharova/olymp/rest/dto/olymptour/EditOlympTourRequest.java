package ru.anna_zaharova.olymp.rest.dto.olymptour;

import ru.anna_zaharova.olymp.entity.OlympFormat;
import ru.anna_zaharova.olymp.entity.OlympLevel;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class EditOlympTourRequest {
    private String olympUrl;
    private String organizer;
    private Integer toursAmount;
    private Integer tourNumber;
    private LocalDate startReg;
    private LocalDate endReg;
    private Boolean isOpenForRequests;
    private LocalDate beginTour;
    private LocalDate endTour;
    private String address;
    private String text;
    private Long olympLevelId;
    private Long olympFormatId;
}
