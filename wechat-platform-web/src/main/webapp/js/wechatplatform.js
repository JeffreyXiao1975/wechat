function openlayer(surl, itype, stitle, swidth, sheight) {
	layer.open({
		type: itype,
		title: stitle,
		maxmin: false,
		area: [swidth, sheight],
		content: surl
	});
}