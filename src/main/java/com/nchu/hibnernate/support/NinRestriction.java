/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nchu.hibnernate.support;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 不包含约束 (from object o where o.value not in (?,?,?,?,?))RestrictionName:NIN
 * <p>
 * 表达式:NIN属性类型_属性名称[_OR_属性名称...]
 * </p>
 * 
 * @author maurice
 *
 */
public class NinRestriction extends CriterionMultipleValueSupport{
	
	/*
	 * (non-Javadoc)
	 * @see com.github.dactiv.orm.core.hibernate.CriterionBuilder#getRestrictionName()
	 */
	public String getRestrictionName() {
		
		return RestrictionNames.NIN;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.dactiv.orm.core.hibernate.restriction.CriterionMultipleValueSupport#buildRestriction(java.lang.String, java.lang.Object[])
	 */
	public Criterion buildRestriction(String propertyName, Object[] values) {
		
		return Restrictions.not(Restrictions.in(propertyName, values));
	}

}

