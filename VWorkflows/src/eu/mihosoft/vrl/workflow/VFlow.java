/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.workflow;

import java.util.Collection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public interface VFlow {

    public void setModel(VFlowModel flow);

    public void setNodeLookup(NodeLookup nodeLookup);

    public NodeLookup getNodeLookup();

    public VFlowModel getModel();

    public ObjectProperty modelProperty();

    public ConnectionResult tryConnect(VNode s, VNode r, String flowType);

    public ConnectionResult connect(VNode s, VNode r, String flowType);

    public ConnectionResult tryConnect(VFlow s, VNode r, String flowType);

    public ConnectionResult tryConnect(VNode s, VFlow r, String flowType);

    public ConnectionResult tryConnect(VFlow s, VFlow r, String flowType);

    public ConnectionResult connect(VFlow s, VNode r, String flowType);

    public ConnectionResult connect(VNode s, VFlow r, String flowType);

    public ConnectionResult connect(VFlow s, VFlow r, String flowType);

    public VNode remove(VNode n);

    public ObservableList<VNode> getNodes();

    public VNode getSender(Connection c);

    public VNode getReceiver(Connection c);

    public void addConnections(Connections connections, String flowType);

    public Connections getConnections(String flowType);

    public void setFlowNodeClass(Class<? extends VNode> cls);

    public Class<? extends VNode> getFlowNodeClass();

    public VNode newNode(ValueObject obj);

    public VNode newNode();

    public VFlow newSubFlow(ValueObject obj);

    public VFlow newSubFlow();

    public Collection<VFlow> getSubControllers();

    public void setSkinFactory(SkinFactory<? extends ConnectionSkin, ? extends VNodeSkin> skinFactory);

    public void setIdGenerator(IdGenerator generator);

    public IdGenerator getIdGenerator();

    public VNodeSkin getNodeSkinById(String id);

    public FlowNodeSkinLookup getNodeSkinLookup();

    public void setNodeSkinLookup(FlowNodeSkinLookup skinLookup);

    public void setVisible(boolean state);

    public boolean isVisible();

    public BooleanProperty visibleState();

    boolean isInputOfType(String type);

    boolean isOutputOfType(String type);

    boolean isInput();

    boolean isOutput();

    void setInput(boolean state, String type);

    void setOutput(boolean state, String type);

    ObservableList<String> getInputTypes();

    ObservableList<String> getOutputTypes();
}