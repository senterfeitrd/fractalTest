package code 
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import java.util.zip.{ZipInputStream, ZipEntry}
import sys.process._
import java.net.URL
import java.io.File
import code.lib._
import Helpers._
import code.model.Node


class HelloWorld {

  val url = new URL("https://snap.stanford.edu/data/web-Stanford.txt.gz") #> new File("dataSet.txt.gz") !!

  val iterator = GzFileIterator(new java.io.File("dataSet.txt.gz"), "UTF-8")
  //val nodesArray : Array[String] = new Array[String](iterator.size - 3)

  var nodesMap: Map[String, Node] = Map()

  iterator.drop(3).foreach{ nodeline:String =>
    val nodeSplit = nodeline.split(" ")
    val node1Id = nodeSplit(0)
    val node2Id = nodeSplit(1)
    var node1 = new Node(node1Id)
    var node2 = new Node(node2Id)

    if (nodesMap.contains(node1Id)) {
      node1 = nodesMap(node1Id)
    } else {
      nodesMap += (node1Id -> node1)
    }

    if (nodesMap.contains(node2Id)) {
      node2 = nodesMap(node2Id)
    } else {
      nodesMap += (node2Id -> node2)
    }

    node1.connections :+ node2
    node2.connections :+ node1
  }

  //def printNodes = "#nodesArray" #> nodeSplit.length


}

