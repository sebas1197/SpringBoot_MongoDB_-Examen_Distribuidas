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
package ec.edu.espe.distribuidas.guarderiadoc.dto;

import lombok.Data;

/**
 *
 * @author Windows Boo
 */
@Data
public class CajeroatmRQ {

    private String id;
    private Integer dineroDisponible;
    private Integer billetes10;
    private Integer billetes20;
}
