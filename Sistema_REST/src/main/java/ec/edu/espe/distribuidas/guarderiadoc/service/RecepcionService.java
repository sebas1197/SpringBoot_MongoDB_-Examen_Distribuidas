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
package ec.edu.espe.distribuidas.guarderiadoc.service;


import ec.edu.espe.distribuidas.guarderiadoc.dao.RecepcionRepository;
import ec.edu.espe.distribuidas.sistemarest.model.Recepcion;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class RecepcionService {

    private final RecepcionRepository recepcionRepo;

    public RecepcionService(RecepcionRepository recepcionRepo) {
        this.recepcionRepo = recepcionRepo;
    }

    public List<Recepcion> listAll() {
        return this.recepcionRepo.findAll();
    }
    
}
