# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 07:19:14 2018

@author: Minkush and Mononito
"""

from .RulesAndCCentroids import cat
from sklearn.preprocessing import OneHotEncoder
import math
import numpy as np
from sklearn.preprocessing import StandardScaler


def Encoding(transaction):
    oneHotEncoder = OneHotEncoder(categories=cat)
    transaction = oneHotEncoder.fit_transform(transaction).toarray()
    sc_X = StandardScaler()
    transaction = sc_X.fit_transform(transaction)
    return transaction    

def BooleanOutlier(NewTrans,centroids, threshold):
    no_of_centroids = len(centroids)
    trans_tran = []
    trans_tran.append(NewTrans)
    NewTrans = np.asarray(trans_tran)
    encoded = Encoding(NewTrans)
    minDis = None
    for i in range(no_of_centroids):
        dimen = len(centroids[i])
        dis = 0
        for j in range(dimen):
            dis+=(encoded[0][j]-centroids[i][j])**2
        dis = math.sqrt(dis)
        
        if(minDis == None):
            minDis = dis
        else:
            minDis = min(minDis,dis)
    
    if minDis <= threshold:
        return True
    else:
        return False
    


        
        