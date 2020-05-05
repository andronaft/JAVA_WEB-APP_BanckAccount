package eduard.krasnui.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(schema = "bankdb" ,name = "account")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Account extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType type;

    @Column(name = "amount")
    private int amount;

    @Column(name = "limit")
    private int limit;

    @Column(name = "percent")
    private int percent;

    @Column(name = "information")
    private String information;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}
