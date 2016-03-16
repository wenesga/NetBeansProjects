// Copyright 2013 GridLine
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nl.gridline.leveldb;

import java.io.Closeable;
import java.util.SortedMap;

import org.iq80.leveldb.DB;

/**
 * <p>
 * {@link SortedMap} interface on top of the {@link DB} implementation
 * </p>
 * @author <a href="mailto:job@gridline.nl">Job</a>
 */
public interface StoredSortedMap<K, V> extends SortedMap<K, V>, Closeable
{

}
