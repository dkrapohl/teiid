/*
 * Copyright Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags and
 * the COPYRIGHT.txt file distributed with this work.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teiid.query.sql.lang;

import java.util.*;

import org.teiid.core.util.UnitTestUtil;
import org.teiid.query.sql.lang.Command;
import org.teiid.query.sql.lang.Drop;
import org.teiid.query.sql.symbol.*;

import junit.framework.*;

public class TestDrop extends TestCase {

	// ################################## FRAMEWORK ################################
	
	public TestDrop(String name) { 
		super(name);
	}	
	
	// ################################## TEST HELPERS ################################	

	public static final Drop sample1() { 
        Drop Drop = new Drop();
        Drop.setTable(new GroupSymbol("temp_table"));//$NON-NLS-1$
        
		List elements = new ArrayList();
        elements.add(new ElementSymbol("a")); //$NON-NLS-1$
        elements.add(new ElementSymbol("b")); //$NON-NLS-1$
	    return Drop;	
	}

	public static final Drop sample2() { 
        Drop Drop = new Drop();
        Drop.setTable(new GroupSymbol("temp_table2"));//$NON-NLS-1$
        
        List elements = new ArrayList();
        elements.add(new ElementSymbol("a")); //$NON-NLS-1$
        elements.add(new ElementSymbol("b")); //$NON-NLS-1$
        return Drop;  	}
			
	// ################################## ACTUAL TESTS ################################
	
	public void testGetProjectedNoElements() {    
	    assertEquals(Command.getUpdateCommandSymbol(), sample1().getProjectedSymbols());
    }

	public void testSelfEquivalence(){
		Drop c1 = sample1();
		int equals = 0;
		UnitTestUtil.helpTestEquivalence(equals, c1, c1);
	}

	public void testEquivalence(){
		Drop c1 = sample1();
        Drop c2 = sample1();
		int equals = 0;
		UnitTestUtil.helpTestEquivalence(equals, c1, c2);
	}
	
	public void testNonEquivalence(){
        Drop c1 = sample1();
        Drop c2 = sample2();
		int equals = -1;
		UnitTestUtil.helpTestEquivalence(equals, c1, c2);
	}	
	
}
