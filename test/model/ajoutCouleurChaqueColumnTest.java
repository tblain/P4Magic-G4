/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 */
package model;

import static model.ChangeColorEffectTest.aGame;
import static model.DisappearEffectTest.aGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class ajoutCouleurChaqueColumnTest {
    static Game aGame;
    public ajoutCouleurChaqueColumnTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        aGame = new Game();
        Board b = new Board(10, 10);
        aGame.setBoard(b);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAjoutCouleurChaqueColumTest() {
        int couleur = aGame.getCurrentPlayer().getId();
        
        int width = aGame.getBoard().getWidth();
        int height = aGame.getBoard().getHeight();
        
        int j = height-1;
        int i = 0;
        
        aGame.getBoard().getTileIJ(height-1, 0).setEffect(new AjoutCouleurChaqueColumn()); // on met l'effet AjoutCouleurColumn sur la première case
        aGame.playMove(0); // puis on joue sur cette case
        
        boolean testReussi = true;
        
        while (i < width) {
            while (j > 0 && aGame.getBoard().getTileIJ(j, i).getStatus() != -1){ // on récupère la case vide juste au dessous de la case
                j--;                                                             // la plus en hauteur
            }
            
            if (aGame.getBoard().getTileIJ(j+1, i).getStatus() != couleur) // on test si la case la plus en hauteur est de la hauteur
                testReussi = false;                                        // est de la couleur du joueur
            i++;
            j = height-1;
        }
        assertTrue("Doit être d'effet AjoutCouleurChaqueColumn", aGame.getBoard().getTileIJ(height - 1, 0).getEffect() instanceof AjoutCouleurChaqueColumn);
        assertTrue(testReussi);
    }
}
