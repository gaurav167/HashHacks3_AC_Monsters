# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 03:07:56 2018

@author: Minkush and Mononito
"""
from scipy import spatial

def Detect(thresholdc,thresholdz,avgLatency,stddev,newTransaction):
    cosineSimilarity = 1 - spatial.distance.cosine(avgLatency,newTransaction)
    zscore = 0
    for i in range(len(avgLatency)):
        if(stddev[i] != 0):
            zscore+=((avgLatency[i]-newTransaction[i])/stddev[i])**2
    zscore/=len(avgLatency)
    cs = None
    if cosineSimilarity > thresholdc:
        cs = True
    else:
        cs = False
    zs = None
    if zscore < thresholdz:
        zs = True
    else:
        zs = False

    
    return cs and zs


def FindAns(Username,Password,newT):
    thresholdc = 0.5
    thresholdz = 2
    return Detect(thresholdc,thresholdz,Username[1],Username[0],newT)

