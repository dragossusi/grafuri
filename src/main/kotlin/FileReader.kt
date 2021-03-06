import java.util.*

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
object FileReader {

    fun readMatrix(fileName: String): Graph {
        return FileReader::class.java.getResourceAsStream(fileName).use {
            val scanner = Scanner(it)
            val size = scanner.nextInt()
            Graph(
                Array(size) {
                    IntArray(size) {
                        scanner.nextInt()
                    }
                }
            )
        }
    }

}