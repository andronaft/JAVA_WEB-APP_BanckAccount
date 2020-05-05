package eduard.krasnui.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "bankdb" ,name = "transaction")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Transaction extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "sum")
    private int sum;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Account senderAccount;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Account receiverAccount;
}
