/*
 *  Copyright 2015-2016 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.twosigma.flint.timeseries.summarize

import org.apache.spark.sql.types._

package object summarizer {
  def anyToDouble(dataType: DataType): Any => Double = dataType match {
    case IntegerType => { any: Any => any.asInstanceOf[Int].toDouble }
    case LongType => { any: Any => any.asInstanceOf[Long].toDouble }
    case FloatType => { any: Any => any.asInstanceOf[Float].toDouble }
    case DoubleType => { any: Any => any.asInstanceOf[Double] }
    case _ => throw new IllegalArgumentException(s"Cannot cast $dataType to DoubleType")
  }
}
