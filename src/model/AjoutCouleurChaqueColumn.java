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

/**
 *
 * @author Thomas
 */
public class AjoutCouleurChaqueColumn extends Effect{
    
    @Override
    public void playEffect(int line, int column, Game game) {
        int couleur = game.getCurrentPlayer().getId(); //couleur du joueur
        
        int width = game.getBoard().getWidth(); // hauteur du tableau
        int height = game.getBoard().getHeight(); // largeur du tableau
        
        int j = height-1; // 
        int i = 0;
        
        
        while (i < width) {
            while (j > 0 && game.getBoard().getTileIJ(j, i).getStatus() != -1){  // on récupère la case vide juste au dessous de la case
                j--;                                                             // la plus en hauteur
                j--;
            }
            game.getBoard().getTileIJ(j, i).setStatus(couleur);
            i++;
            j = height-1;
        }
        
        game.getBoard().getTileIJ(line, column).setEffect(null); // on enleve l'effet
    }
}
