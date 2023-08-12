// Generated from //wsl$/Ubuntu-22.04/home/xzq/project/Mx_compiler/src/Parser\Mx.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void enterMainFn(MxParser.MainFnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void exitMainFn(MxParser.MainFnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefUnit}.
	 * @param ctx the parse tree
	 */
	void enterVarDefUnit(MxParser.VarDefUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefUnit}.
	 * @param ctx the parse tree
	 */
	void exitVarDefUnit(MxParser.VarDefUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constructionFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterConstructionFuncDef(MxParser.ConstructionFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructionFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitConstructionFuncDef(MxParser.ConstructionFuncDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constructionFunc}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void enterConstructionFunc(MxParser.ConstructionFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constructionFunc}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void exitConstructionFunc(MxParser.ConstructionFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMethod}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void enterClassMethod(MxParser.ClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMethod}
	 * labeled alternative in {@link MxParser#classComponent}.
	 * @param ctx the parse tree
	 */
	void exitClassMethod(MxParser.ClassMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcCallArglist}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallArglist(MxParser.FuncCallArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCallArglist}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallArglist(MxParser.FuncCallArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVardefForStmt(MxParser.VardefForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVardefForStmt(MxParser.VardefForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprForStmt(MxParser.ExprForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprForStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprForStmt(MxParser.ExprForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPureExprStmt(MxParser.PureExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPureExprStmt(MxParser.PureExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(MxParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(MxParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreFixExpr(MxParser.PreFixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreFixExpr(MxParser.PreFixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryConditional}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryConditional(MxParser.TernaryConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryConditional}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryConditional(MxParser.TernaryConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberVariableExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberVariableExpr(MxParser.MemberVariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberVariableExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberVariableExpr(MxParser.MemberVariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberFuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberFuncExpr(MxParser.MemberFuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberFuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberFuncExpr(MxParser.MemberFuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseNot(MxParser.BitwiseNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseNot}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseNot(MxParser.BitwiseNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryPlus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlus(MxParser.UnaryPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryPlus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlus(MxParser.UnaryPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(MxParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(MxParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(MxParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(MxParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSufFixExpr(MxParser.SufFixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufFixExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSufFixExpr(MxParser.SufFixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MxParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newSingleArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void enterNewSingleArray(MxParser.NewSingleArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newSingleArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void exitNewSingleArray(MxParser.NewSingleArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClassArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void enterNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClassArray}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void exitNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(MxParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link MxParser#newType}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(MxParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#singleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeName(MxParser.SingleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#singleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeName(MxParser.SingleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterLogicalLiteral(MxParser.LogicalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitLogicalLiteral(MxParser.LogicalLiteralContext ctx);
}