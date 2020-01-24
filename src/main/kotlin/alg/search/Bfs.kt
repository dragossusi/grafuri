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
class Bfs(
    graph: Graph,
    val visit: (Int) -> Unit
) : BaseSearch(graph) {

    val viz = BooleanArray(n)
    val tata = IntArray(n)
    val next = IntArray(n) {
        -1
    }
    val S = IntArray(n)
    var top = -1
    var down = -1

    override fun run(x: Int) {
        visit(x)
        viz[x] = true
        tata[x] = -1
        top = 0
        down = 0
        S[down] = x
        while (top <= down) {
            val i = S[top]
            var j = next[i] + 1
            while (j < n && graph[i, j] == 0) ++j
            if (j >= n) ++top
            else {
                next[i] = j
                if (!viz[j]) {
                    visit(j)
                    viz[j] = true
                    tata[j] = i
                    ++down
                    S[down] = j
                }
            }
        }
    }

    private fun visit(x: Int) {
        visit.invoke(x)
    }

}