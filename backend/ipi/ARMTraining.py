# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 00:52:46 2018

@author: Minkush and Mononito
"""

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_excel("TransactionsData.xlsx")  
size = len(data)
transactions = []
for i in range(0,size):
    transactions.append([str(data.values[i,j]) for j in range(1,8)])
    
#training data set
from apyori import apriori
rules = apriori(transactions,min_support = 0.003 ,min_confidence = 0.02,min_lift = 2 ,min_length = 2)

#visualising the results
results = list(rules)
RulesStored = []
for i in range(len(results)):
    RulesStored.append(list(results[i][0]))



