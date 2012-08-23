/*
 * This file is part of alta-commons.
 *
 * Copyright (c) 2012, alta189 <http://github.com/alta189/DeskBin/>
 * alta-commons is licensed under the GNU Lesser General Public License.
 *
 * alta-commons is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alta-commons is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.commons.util.injectors;

public class EmptyInjector implements Injector {
	public static EmptyInjector instance;

	static {
		instance = new EmptyInjector();
	}

	public static EmptyInjector getInstance() {
		return instance;
	}

	private EmptyInjector() {
	}

	@Override
	public Object newInstance(Class<?> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		} catch (IllegalAccessException e) {
			throw new InjectorException("Could not create a new instance of class '" + clazz.getCanonicalName() + "'", e.getCause());
		}
	}

}