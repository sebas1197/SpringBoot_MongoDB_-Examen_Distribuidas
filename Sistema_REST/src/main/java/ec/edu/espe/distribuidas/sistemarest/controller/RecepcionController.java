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
package ec.edu.espe.distribuidas.sistemarest.controller;


import ec.edu.espe.distribuidas.guarderiadoc.service.RecepcionService;
import ec.edu.espe.distribuidas.sistemarest.model.Recepcion;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Windows Boo
 */
@RestController
@RequestMapping("/v1/recepcion")
@Slf4j
public class RecepcionController {

    private final RecepcionService service;

    public RecepcionController(RecepcionService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Listar movimientos de retiro y abono", notes = "Retorna todos "
            + "los detalles de retiro y abono de dinero")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Movimientos")
    })
    public ResponseEntity listarTodos() {
        List<Recepcion> recepciones = this.service.listAll();
        return ResponseEntity.ok(recepciones.toString());
    }
}
