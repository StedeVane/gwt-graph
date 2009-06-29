package org.thejit.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class GraphWidget extends Widget {

    // native wrapper (like Hypertree)
    private final Graph wrp;
    private final Element chartElement;
    private final String chartElementId;

    private static int count;

    public GraphWidget() {
        count++;

        chartElementId = "swfID_" + count;
        wrp = Graph.newInstance(chartElementId);

        chartElement = DOM.createElement("div");
        DOM.setElementProperty(chartElement, "id", chartElementId);
        setElement(chartElement);
//        setSize("100%", "100%");
    }


    /**
     * Returns a Graph.Node by id.
     */
    public Node getNode(Object id) {
        return wrp.getNode(id);
    }

    /**
     * Returns an array of Graph.Adjacence objects connecting nodes with ids id and id2.
     */
    public void getAdjacence() {
    }

    /**
     * Adds a node.
     */
    public Node addNode(Node node) {
        return wrp.addNode(node);
    }

    /**
     * Connects nodes specified by obj and obj2.
     */
    public Adjacence addAdjacence(Node obj, Node obj2, Node.Data data) {
        return wrp.addAdjacence(obj, obj2, data);
    }

    /**
     * Removes a Graph.Node matching the specified id.
     */
    public void removeNode() {
    }

    /**
     * Removes a Graph.Adjacence matching id1 and id2.
     */
    public void removeAdjacence() {
    }

    /**
     * Returns a Boolean instance indicating if the node belongs to the Graph or not.
     */
    public void hasNode() {
    }

    /**
     * Computes nodes' positions and replots the tree.
     * <p/>
     * reposition - _optional_ Set this to *true* to force repositioning.
     */
    public void refresh() {
        wrp.refresh();
    }

    protected void onAttach() {
//        var infovis = document.getElementById('infovis');
//        var w = infovis.offsetWidth, h = infovis.offsetHeight;
        //init canvas
        //Create a new canvas instance.
        wrp.setCanvas(newCanvas(chartElementId + "_canvas", chartElementId, 200, 200));
        super.onAttach();
    }

    private native JavaScriptObject newCanvas(String newId, String parentId, int w, int h)/*-{
        return new $wnd.Canvas(newId, {
                'injectInto':parentId,
                'width':w,
                'height':h
        });
    }-*/;

    protected void onDetach() {
//        chartElement.removeChild(chartElement.getChildNodes().getItem(0));
        super.onDetach();
    }

    public final static class Node extends JavaScriptObject {
        @Deprecated
        protected Node() {
        }

        public static native Node newInstance(Object node_id, String node_name, Data node_data)/*-{
            return new Graph.Node($extend({
                'id': node_id,
                'name': node_name,
                'data': node_data
            }));
        }-*/;

        /**
         * Indicates if the node is adjacent to the node specified by id
         */
        public void adjacentTo() {
        }

        /**
         * Returns a Graph.Adjacence object connecting the current Graph.Node and the node having id as id.
         */
        public void getAdjacency() {
        }

        /**
         * Connects the current node and the given node.
         */
        public void addAdjacency() {
        }

        /**
         * Removes a Graph.Adjacence by id.
         */
        public void removeAdjacency() {
        }

        public static class Data extends JavaScriptObject {
            protected Data() {
            }
        }
    }

    public final static class Adjacence extends JavaScriptObject {
        @Deprecated
        protected Adjacence() {
        }
        /*
        nodeFrom	A Graph.Node connected by this edge.
nodeTo	Another Graph.Node connected by this edge.
data	Node data property containing a hash (i.e {}) with custom options.  For more information see Loader.loadJSON.
alpha	Current opacity value.
startAlpha	Opacity begin value.  Used for interpolation.
endAlpha	Opacity end value.  Used for interpolation.
*/
    }


}
