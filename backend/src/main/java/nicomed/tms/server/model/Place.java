package nicomed.tms.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.tms.server.enums.Grade;

import javax.persistence.*;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private nicomed.tms.server.model.City city;

    @Enumerated(value = EnumType.STRING)
    private Grade grade;

    public Place(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
}
