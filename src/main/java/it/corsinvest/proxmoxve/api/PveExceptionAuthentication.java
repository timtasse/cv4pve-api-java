/*
 * SPDX-FileCopyrightText: Copyright Corsinvest Srl
 * SPDX-License-Identifier: MIT
 */
package it.corsinvest.proxmoxve.api;

/**
 * Pve Exception Authentication
 */
public class PveExceptionAuthentication extends Exception {

    private final Result result;

    /**
     * Constructor
     *
     * @param result
     * @param errorMessage
     */
    public PveExceptionAuthentication(Result result, String errorMessage) {
        super(errorMessage);
        this.result = result;
    }

    /**
     * Get result
     *
     * @return
     */
    public Result getResult() {
        return result;
    }
}
