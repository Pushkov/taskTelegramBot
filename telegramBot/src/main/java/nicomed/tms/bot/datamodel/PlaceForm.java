package nicomed.tms.bot.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceForm {
    private Long id;
    private String name;
    private String city;
    private String grade;



}
