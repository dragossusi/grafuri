package alg

import Graph
import alg.search.DfsRecursive

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
fun Graph.components() {
    val cc = IntArray(size)
    var nrc = 0
    val dfs = DfsRecursive(this) {
        cc[it] = nrc
    }
    nrc = 0
    for (i in 0 until size) {
        cc[i] = 0
    }
    for (i in 0 until size) {
        if (cc[i] == 0) {
            ++nrc
            dfs.search(i)
        }
    }
}
