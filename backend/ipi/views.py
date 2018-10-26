from django.shortcuts import render
from django.http import HttpResponse, JsonResponse, HttpResponseNotAllowed

@csrf_exempt
def val_payment(request):
	if request.method == "POST":
		data = request.POST
		transaction = data['transaction']
		# call ML pay validation function for transaction validation. Set value to "val"
		val = True
		if val:
			return JsonResponse({'status':'success', 'access':'True'})
		else:
			return JsonResponse({'status':'success', 'access':'False'})
	else:
		return HttpResponseNotAllowed(['POST'])

@csrf_exempt
def login_user(request):
	if request.method == "POST":
		data = request.POST
		usr_name = data['user']
		usr_pass = data['pass']
		# call ML Typing validation function. Set value to "val"
		val = True
		if val:
			return JsonResponse({'status':'success', 'access':'True'})
		else:
			return JsonResponse({'status':'success', 'access':'False'})
	else:
		return HttpResponseNotAllowed(['POST'])