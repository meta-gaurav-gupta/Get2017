/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

/**
 * Gson-based JSON JAX-RS Provider.
 * 
 * We need this not only for using Gson instead of Jackson, but also to be able
 * to register {@link TypeAdapterFactory} instances.
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsonProvider extends GsonMessageBodyHandler{

	public GsonProvider() {
	}

	/**
	 * Hereby one will register every subtypes to be supported by Gson.
	 */
	private static final Gson registerGsonTypeAdapterFactories() {
		GsonBuilder builder = new GsonBuilder();

		// handle double NaN
		builder.serializeSpecialFloatingPointValues();

		// register subtypes
		// builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory
		// .of(Object.class).registerSubtype(SubObjecOne.class)
		// .registerSubtype(SubObjecTwo.class)
		// .registerSubtype(SubObjecThree.class));

		return builder.create();
	}

}
