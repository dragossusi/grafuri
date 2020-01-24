package alg.search

import Graph

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
class DfsRecursive(
    graph: Graph,
    private val visit: (Int) -> Unit
) : BaseSearch(graph) {

    private val viz = BooleanArray(n) { false }
    private val tata = IntArray(n) { 0 }

    override fun run(x: Int) {
        visit(x)
        viz[x] = true
        for (y in 0 until n) {
            if (graph[x, y] >= 1 && !viz[y]) {
                tata[y] = x
                run(y)
            }
        }
    }

    private fun visit(x: Int) {
        visit.invoke(x + 1)
    }

}