package fixed2free;

import org.apache.commons.lang3.StringUtils;

public class RPGSpecs {
	public static String formatHSpec() {
		String result = "";

		return result;

	}

	public static String formatFSpec(String fileName, String fileType,
			String fileDesignation, String endOfFile, String fileAddition,
			String sequence, String fileFormat, String recordLength,
			String limitsProcessing, String keyLength,
			String recordAddressType, String fileOrganization, String device,
			String keywords, String comments) throws RPGFormatException {
		// *.. 1 ...+... 2 ...+... 3 ...+... 4 ...+... 5 ...+... 6 ...+... 7
		// ...+... 8 ...+... 9 ...+... 10
		// FFilename++IPEASFRlen+LKlen+AIDevice+.Keywords+++++++++++++++++++++++++++++Comments++++++++++++
		// FSYSTABLES IFE AE K DISK BLOCK(*YES) This is a comment

		// Check lengths of input fields
		if (fileName == null || fileName.trim().length() > 10) {
			throw new RPGFormatException(
					"File Name must be provided and can not be more than 10 characters in length");
		}

		if (fileType == null || fileType.trim().length() > 1) {
			throw new RPGFormatException(
					"File type must be provided and can not be more that 1 character in length");
		}

		if (fileDesignation == null || fileDesignation.trim().length() > 1) {
			throw new RPGFormatException(
					"File designation must be provided and can not be more than 1 character in length");
		}

		if (endOfFile == null || endOfFile.trim().length() > 1) {
			throw new RPGFormatException(
					"End of file must be provided and can not be more than 1 character in length");
		}

		if (fileAddition == null || fileAddition.trim().length() > 1) {
			throw new RPGFormatException(
					"File addition must be provided and can not be more than 1 character in length");
		}

		if (sequence == null || sequence.trim().length() > 1) {
			throw new RPGFormatException(
					"Sequence must be provided and can not be more than 1 character in length");
		}

		if (fileFormat == null || fileFormat.trim().length() > 1) {
			throw new RPGFormatException(
					"File format must be provided and ca not be more than 1 character in length");
		}

		if (recordLength == null || recordLength.trim().length() > 5) {
			throw new RPGFormatException(
					"Record length must be provided and can not be more than 5 characters in length");
		}

		if (limitsProcessing == null || limitsProcessing.trim().length() > 1) {
			throw new RPGFormatException(
					"Limits processing must be provided and can not be more that 1 character in length");
		}

		if (keyLength == null || keyLength.trim().length() > 5) {
			throw new RPGFormatException(
					"Key length must be provided and can not be more than 1 character in length");
		}

		if (recordAddressType == null || recordAddressType.trim().length() > 1) {
			throw new RPGFormatException(
					"Record address type must be provided and can not be more than 1 character in length");
		}

		if (fileOrganization == null || fileOrganization.trim().length() > 1) {
			throw new RPGFormatException(
					"File organization must be provided and can not be more than 1 character in length");
		}

		if (device == null || device.trim().length() > 7) {
			throw new RPGFormatException(
					"Device must be provided and can not be more than 7 characters in length");

		}

		if (keywords == null || keywords.trim().length() > 37) {
			throw new RPGFormatException(
					"Keywords must be provided and can not be more than 37 characters in length");
		}

		String result = "     " + "F" + StringUtils.rightPad(fileName, 10)
				+ fileType + fileDesignation + endOfFile + fileAddition
				+ sequence + fileFormat
				+ StringUtils.leftPad(recordLength.trim(), 5)
				+ limitsProcessing + StringUtils.leftPad(keyLength.trim(), 5)
				+ recordAddressType + fileOrganization
				+ StringUtils.rightPad(device.trim(), 7) + ' '
				+ StringUtils.rightPad(keywords, 37) + comments;

		return result;
	}

	public static String formatFCont(String keywords, String comment)
			throws RPGFormatException {
		String result = "";
		if (keywords == null || keywords.trim().length() > 37) {
			throw new RPGFormatException(
					"Keywords must be provided and can not be more than 37 characters in length");
		}

		result = "     F" + StringUtils.repeat(' ', 38)
				+ StringUtils.rightPad(keywords, 37) + comment;

		// *.. 1 ...+... 2 ...+... 3 ...+... 4 ...+... 5 ...+... 6 ...+... 7
		// ...+... 8 ...+... 9 ...+... 10
		// F.....................................Keywords+++++++++++++++++++++++++++++Comments++++++++++++

		return result;
	}

	public static String formatDSpec(String name, String externalDescription,
			String typeOfDataStructure, String definitionType,
			String fromPosition, String toPosition, String internalDataType, String decimalPositions, String keywords, String comment)
			throws RPGFormatException {
		//     *.. 1 ...+... 2 ...+... 3 ...+... 4 ...+... 5 ...+... 6 ...+... 7 ...+... 8 ...+... 9 ...+... 10
		//     DName+++++++++++ETDsFrom+++To/L+++IDc.Keywords+++++++++++++++++++++++++++++Comments++++++++++++
		//     DName                            7A   INZ(*BLANKS)                         Another comment

		String result = "";
		// Test input parms and make sure that they fit in limits
		if (name == null || name.trim().length() > 15) {
			throw new RPGFormatException(
					"Name must be provided and can not be more than 15 characters in length");
		}
		if (externalDescription == null
				|| externalDescription.trim().length() > 1) {
			throw new RPGFormatException(
					"External Description must be provided and can not be more than 15 characters in length");
		}
		if (typeOfDataStructure == null
				|| typeOfDataStructure.trim().length() > 1) {
			throw new RPGFormatException(
					"Type of data structure must be provided and can not be more than 1 character in length");
		}
		if (definitionType == null || definitionType.trim().length() > 2) {
			throw new RPGFormatException(
					"Definition Type must be provided and can not be more than 2 characters in length");
		}
		if (fromPosition == null || fromPosition.trim().length() > 7) {
			throw new RPGFormatException(
					"From Position must be provided and can not be more than 7 characters in length");
		}
		if (toPosition == null || toPosition.trim().length() > 7) {
			throw new RPGFormatException(
					"To Position must be provided and can not be more than 7 characters in length");
		}
		if (internalDataType == null
				|| internalDataType.trim().length() > 1) {
			throw new RPGFormatException(
					"Internal Data Type must be provided and can not be more than 1 character in length");
		}
		if (decimalPositions == null || decimalPositions.trim().length() > 2) {
			throw new RPGFormatException(
					"Decimal Positions must be provided and can not be more than 2 characters in length");
		}
		if (keywords == null || keywords.trim().length() > 37){
			throw new RPGFormatException("Keywords must be provided and can not be more than 37 characters in length");
		}
		if (comment == null){
			throw new RPGFormatException("Comment must be provided");
		}
		result = "     D" + StringUtils.rightPad(name, 15)
				+ externalDescription + typeOfDataStructure
				+ StringUtils.rightPad(definitionType, 2)
				+ StringUtils.leftPad(fromPosition, 7)
				+ StringUtils.leftPad(toPosition, 7)
				+ internalDataType
				+ StringUtils.leftPad(decimalPositions, 2)
				+ ' '
				+ StringUtils.rightPad(keywords, 37)
				+ comment
				;
		return result;

	}
	public static String formatCSpec(String controlLevel, String not, String indicator, String factor1, String opCode, String factor2, String result, String length, String decPos, String hi, String lo, String eq, String comments ) throws RPGFormatException{
		//Check field lengths of input parms
		if (controlLevel == null || controlLevel.trim().length() > 2){
			throw new RPGFormatException(
					"Control Level must be provided and can not be more than 2 characters in length");
		}
		if (not == null || not.trim().length() > 1){
			throw new RPGFormatException(
					"And/Not must be provided and can not be more than 1 characters in length");
		}
		if (indicator == null || indicator.trim().length() > 2){
			throw new RPGFormatException(
					"Conditioning Indicator must be provided and can not be more than 2 characters in length");
		}
		if (factor1 == null || factor1.trim().length() >14){
			throw new RPGFormatException(
					"Factor1 must be provided and can not be more than 14 characters in length");
		}
		if (opCode == null || opCode.trim().length() > 10){
			throw new RPGFormatException(
					"OpCode must be provided and can not be more than 10 characters in length");
		}
		if (factor2 == null || factor2.trim().length() > 14){
			throw new RPGFormatException(
					"Factor 2 must be provided and can not be more than 14 characters in length");
		}
		if (result == null || result.trim().length() > 14){
			throw new RPGFormatException(
					"Result must be provided and can not be more than 14 characters in length");
		}
		if (length == null || length.trim().length() > 5){
			throw new RPGFormatException(
					"Length must be provided and can not be more than 5 characters in length");
		}
		if (decPos == null || decPos.trim().length() > 2){
			throw new RPGFormatException(
					"Decimal Position must be provided and can not be more than 2 characters in length");
		}
		if (hi == null || hi.trim().length() > 2){
			throw new RPGFormatException(
					"High Indicator must be provided and can not be more than 2 characters in length");
		}
		if (lo == null || lo.trim().length() > 2){
			throw new RPGFormatException(
					"Low Indicator must be provided and can not be more than 2 characters in length");
		}
		if (eq == null || eq.trim().length() > 2){
			throw new RPGFormatException(
					"Equal Indicator must be provided and can not be more than 2 characters in length");
		}

		//     *.. 1 ...+... 2 ...+... 3 ...+... 4 ...+... 5 ...+... 6 ...+... 7 ...+... 8 ...+... 9 ...+... 10
		//     CL0N01Factor1+++++++Opcode(E)+Factor2+++++++Result++++++++Len++D+HiLoEq....Comment
		
		String output = "     C" + StringUtils.rightPad(controlLevel, 2) + not + StringUtils.rightPad(indicator, 2) + StringUtils.rightPad(factor1, 14) + StringUtils.rightPad(opCode, 10) + StringUtils.rightPad(factor2, 14) 
				+ StringUtils.rightPad(result, 14) + StringUtils.leftPad(length, 5) + StringUtils.leftPad(decPos, 2) + StringUtils.rightPad(hi, 2) + StringUtils.rightPad(lo, 2) + StringUtils.rightPad(eq, 2) + "    " + comments ;
		
		
		return output;
	}

}
