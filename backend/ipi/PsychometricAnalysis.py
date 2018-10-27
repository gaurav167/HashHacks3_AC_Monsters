# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 07:57:52 2018

@author: Minkush
"""

from .Keystrokedynamics import *
from .RulesAndCCentroids import *
import pickle
import sklearn
import os

def gesturetest(GestureData):
    # __location__ = os.path.realpath(os.path.join(os.getcwd(), os.path.dirname(__file__)))
    with open(os.path.abspath("GesturesModel.txt"),"rb") as fo:
        obj = pickle.load(fo)
    
    y_pred = obj.predict(GestureData)
    gest = False
    if y_pred in AuthenticatedUsers:
        gest = True
    else:
        gest = False
    
    return gest
    

def typingtest(Username,Password,NewUsername,NewPass):
    Typing1 = FindAns(Username,Password,NewUsername)
    Typing2 = FindAns(Password,Password,NewPass)
    
    return Typing1 and Typing2 


# print(typingtest(HarshBhardwaj,harsh123,[0.0,1,2,3,4,5,6,7,8,9,10,11,12], [0.0,1,2,3,4,5,6,7]))