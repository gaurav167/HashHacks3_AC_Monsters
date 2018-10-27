# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 07:35:49 2018

@author: Minkush
"""

def RuleMatching(newT,Rules,threshold):
    maxintersect = None
    for rule in Rules:
        intersect = 0
        for item in rule:
            if item in newT:
                intersect+=1
        if maxintersect == None:
            maxintersect = intersect
        else: 
            maxintersect = max(maxintersect,intersect)
            
    
    if maxintersect < threshold:
        return False
    else:
        return True
    

                