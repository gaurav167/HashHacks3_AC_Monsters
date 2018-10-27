# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 07:42:22 2018

@author: Minkush
"""

from .RulesAndCCentroids import *
from .OutlierAnalysis import *
from .RuleMatcher import *

def Wrapper1(newT):
    #print(newT)
    ISOutlier = BooleanOutlier(newT,Centroids,2)
    DoesRuleMatched = RuleMatching(newT,RulesARM,2)
    
    ans = []
    ans.append(ISOutlier)
    ans.append(DoesRuleMatched)

    
    if(ans.count(True) > 1):
        return True
    else:
        return False

