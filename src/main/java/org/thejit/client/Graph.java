package org.thejit.client;

import com.google.gwt.core.client.JavaScriptObject;

final class Graph extends JavaScriptObject {
    public static native Graph newInstance(String dummyId) /*-{
        var  dummyCanvas = {
          'id':dummyId
        };

        return new $wnd.RGraph(dummyCanvas, {
            Node: {
                overridable: true,
                'transform': false,
                color: "#f00"
            },

            Edge: {
                overridable: true,
                color: "#088"
            },
//            transition: Trans.Back.easeOut,
            duration: 500,

            fps: 30,
            //Change father-child distance.
            levelDistance: 200
        });
      }-*/;


    native GraphWidget.Node getNode(Object id)/*-{
        return this.getNode(id);
    }-*/;

    native GraphWidget.Adjacence addAdjacence(GraphWidget.Node id1, GraphWidget.Node id2, GraphWidget.Node.Data data)/*-{
        return this.addAdjacence(id1, id2, data);
    }-*/;

    native GraphWidget.Node addNode(GraphWidget.Node node)/*-{        
        return this.addNode(node);
    }-*/;

    native void refresh() /*-{
        this.refresh();
    }-*/;


    public native void setCanvas(JavaScriptObject canvas) /*-{
        this.canvas = canvas;
    }-*/;


    public static final class Util extends JavaScriptObject {

        protected Util() {
        }

        /**
         * Returns a Graph.Node by id.
         */
        public void getNode() {
        }

        /**
         * Iterates over Graph nodes performing an action.
         */
        public void eachNode() {
        }

        /**
         * Iterates over Graph.Node adjacencies applying the action function.
         */
        public void eachAdjacency() {
        }

        /**
         * Performs a BFS traversal setting the correct depth for each node.
         */
        public void computeLevels() {
        }

        /**
         * Performs a BFS traversal applying action to each Graph.Node.
         */
        public void eachBFS() {
        }

        /**
         * Iterates over a node’s subgraph applying action to the nodes of relative depth between levelBegin and levelEnd.
         */
        public void eachLevel() {
        }

        /**
         * Iterates over a node’s children recursively.
         */
        public void eachSubgraph() {
        }

        /**
         * Iterates over a node’s children (without deeper recursion).
         */
        public void eachSubnode() {
        }

        /**
         * Returns true if any subnode matches the given condition.
         */
        public void anySubnode() {
        }

        /**
         * Collects all subnodes for a specified node.
         */
        public void getSubnodes() {
        }

        /**
         * Returns an Array of Graph.Nodes wich are parents of the given node.
         */
        public void getParents() {
        }

        /**
         * Cleans flags from nodes (by setting the flag property to false).
         */
        public void clean() {
        }
    }

    @Deprecated
    protected Graph() {
    }
}
