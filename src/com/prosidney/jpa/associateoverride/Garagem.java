package com.prosidney.jpa.associateoverride;

import javax.persistence.AssociationOverride;
import javax.persistence.JoinColumn;

/**
 * Created by Sidney on 2017-04-04.
 */
public class Garagem {

    @AssociationOverride(
            name="mailbox",
            joinColumns= {
                    @JoinColumn(name="MBX_ID"),
                    @JoinColumn(name="MBX_ID_1")
            }
    )
    private Carro carro;


    @AssociationOverride(
            name="mailbox",
            joinColumns=@JoinColumn(name="MBX_ID")
    )
    private Carro carro1;
}
