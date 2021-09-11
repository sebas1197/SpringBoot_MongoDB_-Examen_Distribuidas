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

import ec.edu.espe.distribuidas.sistemarest.model.Cajeroatm;
import ec.edu.espe.distribuidas.guarderiadoc.service.CajeroatmService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/cajeroatm")
@Slf4j
public class CajeroatmController {

    private final CajeroatmService service;

    public CajeroatmController(CajeroatmService service) {
        this.service = service;
    }

       @GetMapping(value = "{monto}")
    @ApiOperation(value = "Obtiene los cajeros que tienen menos de x monto", notes = "Retorna los "
            + "cajeros deacuerdo a su monto")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Cajeros encontrados"),
        @ApiResponse(code = 404, message = "No existen cajeros para "
                + "el monto enviado")})
    public ResponseEntity calcularMonto(
            @PathVariable("monto") Integer monto) {
        try {
            List<Cajeroatm> cajeros = this.service.listAll();
            List<Cajeroatm> cajerosMonto = this.service.findByMonto(monto);
            for(Cajeroatm i: cajeros){
                if(i.getDineroDisponible() < monto ){
                    cajerosMonto.add(i);
                }
            }
            return ResponseEntity.ok(cajerosMonto.toString());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    @ApiOperation(value = "Listar Cajeros atm", notes = "Retorna todos "
            + "los cajeros atm")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Muestra todos los"
                + " cajeros atm con detalle del monto y numero de billetes por denominacion")
    })
    public ResponseEntity listarTodos() {
        List<Cajeroatm> cajeros = this.service.listAll();
        return ResponseEntity.ok(cajeros.toString());
    }

   
}
