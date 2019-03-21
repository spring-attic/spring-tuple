/*
 * Copyright 2013-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.integration.transformer.AbstractPayloadTransformer;
import org.springframework.tuple.Tuple;
import org.springframework.tuple.TupleBuilder;

/**
 * Converts from a Map to the Tuple data structure.
 * 
 * @author Mark Pollack
 * @author Ilayaperumal Gopinathan
 */
public class MapToTupleTransformer extends AbstractPayloadTransformer<Map<Object, Object>, Tuple> {

	@Override
	public Tuple transformPayload(Map<Object, Object> map) {

		List<String> newNames = new ArrayList<String>();
		List<Object> newValues = new ArrayList<Object>();
		for (Map.Entry<Object, Object> entry: map.entrySet()) {
			newNames.add(entry.getKey().toString());
			newValues.add(entry.getValue());
		}
		return TupleBuilder.tuple().ofNamesAndValues(newNames, newValues);

	}
}
