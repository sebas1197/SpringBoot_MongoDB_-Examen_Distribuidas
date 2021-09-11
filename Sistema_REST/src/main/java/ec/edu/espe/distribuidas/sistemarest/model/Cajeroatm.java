/*
 * Copyright (c) 2021 Windows Boo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Windows Boo - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.sistemarest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cajeroatm")
public class Cajeroatm {

    @Id
    private String id;
    private Integer dineroDisponible;
    private Integer billetes10;
    private Integer billetes20;
    
}
