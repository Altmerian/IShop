<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ishop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="shoppingCart">
	<div class="alert alert-warning hidden-print" role="alert">To make order, please sign in</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Product</th>
				<th>Price</th>
				<th>Count</th>
				<th class="hidden-print">Action</th>
			</tr>
		</thead>
		<tbody>
			<tr id="product278009" class="item">
				<td class="text-center"><img class="small" src="/media/736d61727470686f6e65.jpg" alt="Prestigio SH398187"><br>Prestigio SH398187</td>
				<td class="price">$ 570.00</td>
				<td class="count">1</td>
				<td class="hidden-print"><a class="btn btn-danger remove-product" data-id-product="278009" data-count="1">Remove one</a></td>
			</tr>
			<tr id="product278014" class="item">
				<td class="text-center"><img class="small" src="/media/652d626f6f6b.jpg" alt="EvroMedia NU6353951"><br>EvroMedia NU6353951</td>
				<td class="price">$ 2710.00</td>
				<td class="count">2</td>
				<td class="hidden-print"><a class="btn btn-danger remove-product" data-id-product="278014" data-count="1">Remove one</a><br>
				<br> <a class="btn btn-danger remove-product all" data-id-product="278014" data-count="2">Remove all</a></td>
			</tr>
			<tr>
				<td colspan="2" class="text-right"><strong>Total:</strong></td>
				<td colspan="2" class="total">$5990.00</td>
			</tr>
		</tbody>
	</table>
	<div class="row hidden-print">
		<div class="col-md-4 col-md-offset-4 col-lg-2 col-lg-offset-5">
			<a class="btn btn-primary btn-block"><i class="fa fa-facebook-official" aria-hidden="true"></i> Sign in</a>
		</div>
	</div>
</div>