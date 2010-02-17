/*
 * Copyright 2007-2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/*
 * BTraceCustomizer.java
 *
 * Created on Sep 9, 2008, 12:21:33 PM
 */

package net.java.btrace.visualvm.api.options;

import net.java.btrace.visualvm.api.BTraceSettings;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@sun.com>
 */
public class BTraceCustomizer extends javax.swing.JPanel {
    BTraceOptionsPanelController controller;
    /** Creates new form BTraceCustomizer */
    public BTraceCustomizer(BTraceOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dumpClassPathLabel = new javax.swing.JLabel();
        dumpClassPath = new javax.swing.JTextField();
        dumpCheck = new javax.swing.JCheckBox();
        debugCheck = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        dumpClassPathLabel.setText(org.openide.util.NbBundle.getMessage(BTraceCustomizer.class, "BTraceCustomizer.dumpClassPathLabel.text")); // NOI18N
        dumpClassPathLabel.setEnabled(false);

        dumpClassPath.setText(org.openide.util.NbBundle.getMessage(BTraceCustomizer.class, "BTraceCustomizer.dumpClassPath.text")); // NOI18N
        dumpClassPath.setEnabled(false);

        dumpCheck.setText(org.openide.util.NbBundle.getMessage(BTraceCustomizer.class, "BTraceCustomizer.dumpCheck.text")); // NOI18N
        dumpCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dumpCheckActionPerformed(evt);
            }
        });

        debugCheck.setText(org.openide.util.NbBundle.getMessage(BTraceCustomizer.class, "BTraceCustomizer.debugCheck.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(debugCheck)
                        .addGap(18, 18, 18)
                        .addComponent(dumpCheck))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dumpClassPathLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dumpClassPath, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(debugCheck)
                    .addComponent(dumpCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dumpClassPathLabel)
                    .addComponent(dumpClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dumpCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dumpCheckActionPerformed
        updateEnablement();
    }//GEN-LAST:event_dumpCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox debugCheck;
    private javax.swing.JCheckBox dumpCheck;
    private javax.swing.JTextField dumpClassPath;
    private javax.swing.JLabel dumpClassPathLabel;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    synchronized void load() {
        debugCheck.setSelected(BTraceSettings.sharedInstance().isDebugMode());
        dumpCheck.setSelected(BTraceSettings.sharedInstance().isDumpClasses());
        dumpClassPath.setText(BTraceSettings.sharedInstance().getDumpClassPath());
        updateEnablement();
    }

    synchronized void store() {
        BTraceSettings.sharedInstance().setDebugMode(debugCheck.isSelected());
        BTraceSettings.sharedInstance().setDumpClasses(dumpCheck.isSelected());
        if (dumpCheck.isSelected()) {
            BTraceSettings.sharedInstance().setDumpClassPath(dumpClassPath.getText());
        }
//        BTraceSettings.sharedInstance().setDumpClassPath(pluginsController.toString());
//        JConsoleSettings.getDefault().setPolling(Integer.valueOf(period.getText()));
    }

    boolean valid() {
        return false;
    }

    private void updateEnablement() {
        if (dumpCheck.isSelected()) {
            dumpClassPath.setEnabled(true);
            dumpClassPathLabel.setEnabled(true);
        } else {
            dumpClassPath.setEnabled(false);
            dumpClassPathLabel.setEnabled(false);
        }
    }
}
