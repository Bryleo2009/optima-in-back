package ofsystem.optima_in.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voucher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    private String id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String path;

    @Column(nullable = false, length = 200)
    private String type;

    @Column(nullable = false, length = 200)
    private String size;

    @Column(nullable = false, length = 200)
    private String date;
}
