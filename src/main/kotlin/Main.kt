import alg.dijkstra
import alg.royFloyd
import alg.royWarshall
import alg.search.Bfs
import alg.search.DfsIterative
import alg.search.DfsRecursive
import alg.strongComponents

/**
 * grafuri
 *
 * Copyright (C) 2020  Rachieru Dragos-Mihai
 *
 * grafuri is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * grafuri is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with grafuri.  If not, see [License](http://www.gnu.org/licenses/) .
 *
 */

fun main() {
    val graph: Graph = FileReader.readMatrix("graph.mat")
    println(graph)
    DfsRecursive(graph, ::visit).search(3)
    DfsIterative(graph, ::visit).search(3)
    Bfs(graph, ::visit).search(3)
    println(graph.royWarshall())
    println(graph.strongComponents())
    println(graph.royFloyd())
    println(graph.dijkstra(3))
    println("Finished")
}

fun visit(number: Int) {
    print("$number ")
}