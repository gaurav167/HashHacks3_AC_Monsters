from django.shortcuts import render
from django.http import HttpResponse, JsonResponse, HttpResponseNotAllowed

def val_payment(request):
	if request.method == "POST":
		
	else:
		return HttpResponseNotAllowed(['POST'])